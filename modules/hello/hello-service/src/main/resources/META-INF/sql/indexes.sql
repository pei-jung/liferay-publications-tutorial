create index IX_1FCFFF5D on FOO_Foo (field2, ctCollectionId);
create index IX_531211A5 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId, ctCollectionId);
create index IX_A5AD8C9F on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], ctCollectionId);
create unique index IX_6E6579E7 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId, ctCollectionId);