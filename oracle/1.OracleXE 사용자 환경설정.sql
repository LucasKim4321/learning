UPDATE sys.props$ SET VALUE$='KO16MSWIN949' WHERE NAME ='NLS_CHARACTERSET';
UPDATE sys.props$ SET VALUE$='KO16MSWIN949' WHERE NAME ='NLS_NCHAR_CHARACTERSET';
UPDATE sys.props$ SET VALUE$='KOREAN_KOREA.KO16MSWIN949' WHERE NAME ='NLS_LANGUAGE';
UPDATE sys.props$ SET VALUE$='KOREAN' WHERE NAME ='NLS_DATE_LANGUAGE';
UPDATE sys.props$ SET VALUE$='KOREA' WHERE NAME ='NLS_TERRITORY';
UPDATE sys.props$ SET VALUE$='KOREA' WHERE NAME ='NLS_ISO_CURRENCY';
UPDATE sys.props$ SET VALUE$='YYYY/MM/DD HH24:MI:SS' WHERE NAME ='NLS_DATE_FORMAT';
UPDATE sys.props$ SET VALUE$='HH24:MI:SSXFF' WHERE NAME ='NLS_TIME_FORMAT';
UPDATE sys.props$ SET VALUE$='YYYY/MM/DD HH24:MI:SSXFF' WHERE NAME ='NLS_TIMESTAMP_FORMAT';
UPDATE sys.props$ SET VALUE$='HH24:MI:SSXFF TZR' WHERE NAME ='NLS_TIME_TZ_FORMAT';
UPDATE sys.props$ SET VALUE$='YYYY/MM/DD HH24:MI:SSXFF TZR' WHERE NAME ='NLS_TIMESTAMP_TZ_FORMAT';
UPDATE sys.props$ SET VALUE$='\' WHERE NAME ='NLS_CURRENCY';
COMMIT;
SHUTDOWN IMMEDIATE;
STARTUP MOUNT;



