drop view if exists entity_search;

create materialized view entity_search as
select "Name"        as name,
       'OBJECT'      as type,
       "Object_ID"   as id,
       "Package_ID"  as package,
       "Object_Type" as detailedType
from t_object
where "Name" is not null
union
select "Name"         as name,
       'DIAGRAM'      as type,
       "Diagram_ID"   as id,
       "Package_ID"   as package,
       "Diagram_Type" as detailedType
from t_diagram
where "Name" is not null
union
select "Name"       as name,
       'PACKAGE'    as type,
       "Package_ID" as id,
       "Parent_ID"  as package,
       null         as detailedType
from t_package
where "Name" is not null;
