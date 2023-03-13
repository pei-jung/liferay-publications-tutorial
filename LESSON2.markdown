# Publications Tutorial

## Lesson 2

In this lesson we will cover how to change track your first entity.

Change tracking an entity comprises of these parts:
- Enable change tracking in the service.xml
- Adding an upgrade process
- Adding a TableDefinitionTest
- Adding a TableReferenceDefinition
- Adding a CTDisplayRenderer

Run `gw deploy` to deploy the modules.

### Enable change tracking in the service.xml
Change tracking leverages Service Builder.  Making something "change tracked" really just means adding the column ctCollectionId to the table. 

- Open service.xml in hello-service
- Add `change-tracking-enabled="true"`. Note that you can apply it either on the entire service.xml or at the entity level.
- Rebuild services
- Double check the indexes.sql. Every entity that has been changed track needs to include ctCollectionId to all indexes. Indexes with ExternalReferenceCode column sometimes does not get updated correctly.

Also note, change tracking requires the entity to also support MVCC.

### Adding an upgrade process
Now we must create an Upgrade Process to add the new column.

Because the process is the same for any table, a helper class has already been created `CTModelUpgradeProcess`.  Just pass in the new table name.

### Adding a TableReferenceDefinitionTest
Next we need to create a TableReferenceDefinition. This will define the relationship of the entity to other entities.  You must declare the parents and their children. 

But before we do that I recommend we create the test first.  This will allow us to easily validate that we've defined the relationship correctly. I recommend you look at an existing one first by search for *TableReferenceDefinitionTest.

You may not be able to complete this step inside this tutorial as integration tests are not well supported in Liferay Workspace.

### Adding a TableReferenceDefinition
The goal of the TableReferenceDefinition is to define the relationship an entity with other entities. This allows us to perform actions like discarding and moving entries properly.

A relationship should only be defined one time... meaning the parent defines it or the child defines it, who declares it is your goal.

If the entity is created automatically, it should be defined by the parent.  If the child is created optionally at a later time, it should be declared most of the time unless creating it changes the parent in some way.

- Create FooTableRefenceDefinition in hello-service
- Declare the children
- Declare the parents

### Adding a CTDisplayRenderer
Finally we need to create a CTDisplayRenderer.  This is the class that generates the previews when viewing changes.

Here you can generate a visual representation, hide certain rows from the table view, and decide if the entry should be hidden or not.

### Review a real example

Take a look at this example to get a better understanding: https://github.com/liferay-publications/liferay-portal/pull/460