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
  7: CDBDriver driver
}

struct CTask{
 1: i32 name,
 2: string cronTime,
 3: userName,
 4: List<CDB> dbs
}

service APITaskService{

}
