ALTER TABLE NETWORK_PLACES DROP COLUMN PARENT_RESOURCE_PERMISSION;

ALTER TABLE NETWORK_PLACES ADD COLUMN HOST VARCHAR;
ALTER TABLE NETWORK_PLACES ADD COLUMN PORT INTEGER;
ALTER TABLE NETWORK_PLACES ADD COLUMN USERNAME VARCHAR;
ALTER TABLE NETWORK_PLACES ADD COLUMN PASSWORD VARCHAR;

ALTER TABLE NETWORK_PLACES ADD COLUMN REALM_ID INTEGER DEFAULT 1;

// Reset the scheme so it gets redetected
UPDATE NETWORK_PLACES SET SCHEME = '';
