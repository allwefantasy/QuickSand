#
# Autogenerated by Thrift Compiler (0.9.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#

require 'thrift'

class CDBDriver
  include ::Thrift::Struct, ::Thrift::Struct_Union
  DRIVERNAME = 1
  URL = 2

  FIELDS = {
    DRIVERNAME => {:type => ::Thrift::Types::STRING, :name => 'driverName'},
    URL => {:type => ::Thrift::Types::STRING, :name => 'url'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end

class CDB
  include ::Thrift::Struct, ::Thrift::Struct_Union
  SQL = 1
  DBHOST = 2
  DBPORT = 3
  DBUSERNAME = 4
  DBPASSWORD = 5
  DBNAME = 6
  DRIVER = 7
  PREFIX = 8

  FIELDS = {
    SQL => {:type => ::Thrift::Types::STRING, :name => 'sql'},
    DBHOST => {:type => ::Thrift::Types::STRING, :name => 'dbHost'},
    DBPORT => {:type => ::Thrift::Types::I32, :name => 'dbPort'},
    DBUSERNAME => {:type => ::Thrift::Types::STRING, :name => 'dbUserName'},
    DBPASSWORD => {:type => ::Thrift::Types::STRING, :name => 'dbPassword'},
    DBNAME => {:type => ::Thrift::Types::STRING, :name => 'dbName'},
    DRIVER => {:type => ::Thrift::Types::STRUCT, :name => 'driver', :class => ::CDBDriver},
    PREFIX => {:type => ::Thrift::Types::STRING, :name => 'prefix'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end

class CTask
  include ::Thrift::Struct, ::Thrift::Struct_Union
  NAME = 1
  CRONTIME = 2
  USERNAME = 3
  DBS = 4
  BATCHSAVENUM = 5

  FIELDS = {
    NAME => {:type => ::Thrift::Types::I32, :name => 'name'},
    CRONTIME => {:type => ::Thrift::Types::STRING, :name => 'cronTime'},
    USERNAME => {:type => ::Thrift::Types::STRING, :name => 'userName'},
    DBS => {:type => ::Thrift::Types::LIST, :name => 'dbs', :element => {:type => ::Thrift::Types::STRUCT, :class => ::CDB}},
    BATCHSAVENUM => {:type => ::Thrift::Types::I32, :name => 'batchSaveNum'}
  }

  def struct_fields; FIELDS; end

  def validate
  end

  ::Thrift::Struct.generate_accessors self
end
