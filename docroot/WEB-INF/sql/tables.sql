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

create table EmailTemplates_ScheduleEntity (
	scheduleId LONG not null primary key,
	scheduleName VARCHAR(75) null,
	scheduleStore VARCHAR(75) null,
	scheduleType VARCHAR(75) null,
	scheduleFlagValue VARCHAR(75) null,
	scheduleOp VARCHAR(75) null,
	scheduleActive BOOLEAN,
	templateId LONG
);