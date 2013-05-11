create table EmailTemplate_EmailTemplateEntity (
	templateId LONG not null primary key,
	templateSubject VARCHAR(75) null,
	templateBody VARCHAR(75) null,
	templateSender VARCHAR(75) null
);

create table EmailTemplates_EmailTemplateEntity (
	templateId LONG not null primary key,
	templateSubject VARCHAR(75) null,
	templateBody VARCHAR(75) null,
	templateSender VARCHAR(75) null
);