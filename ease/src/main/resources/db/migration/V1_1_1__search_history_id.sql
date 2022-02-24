alter table ease.public.search_history
    drop column id;

alter table ease.public.search_history
    add column id SERIAL not null primary key;
