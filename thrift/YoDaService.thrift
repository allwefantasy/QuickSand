namespace java net.csdn.api

struct CDBDriver{
  1: string driverName,
  2: string url
}

struct CDB{
  1: string sql,
  2: string dbHost,
  3: i32 dbPort,
  4: string dbUserName,
  5: string dbPassword,
  6: string dbName,
  7: CDBDriver driver,
  8: string prefix
}

struct CTask{
 1: i32 name,
 2: string cronTime,
 3: string userName,
 4: list<CDB> dbs,
 5: i32 batchSaveNum
}

service DBDumpService{
   void dump(1:CTask task)
}

service DBLoadService{
   void load(1:string prefix,2:string objectList )
}

service DBTaskService{
   void createTask(1:CTask task)
   void startTask(1:string name);
   void cancelTask(1:string name);
   void listTask();
}
