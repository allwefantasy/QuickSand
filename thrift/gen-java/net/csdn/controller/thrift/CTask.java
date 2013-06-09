/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package net.csdn.controller.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CTask implements org.apache.thrift.TBase<CTask, CTask._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CTask");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CRON_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("cronTime", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField DBS_FIELD_DESC = new org.apache.thrift.protocol.TField("dbs", org.apache.thrift.protocol.TType.LIST, (short)4);
  private static final org.apache.thrift.protocol.TField BATCH_SAVE_NUM_FIELD_DESC = new org.apache.thrift.protocol.TField("batchSaveNum", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CTaskStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CTaskTupleSchemeFactory());
  }

  public String name; // required
  public String cronTime; // required
  public String userName; // required
  public List<CDB> dbs; // required
  public int batchSaveNum; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    CRON_TIME((short)2, "cronTime"),
    USER_NAME((short)3, "userName"),
    DBS((short)4, "dbs"),
    BATCH_SAVE_NUM((short)5, "batchSaveNum");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // CRON_TIME
          return CRON_TIME;
        case 3: // USER_NAME
          return USER_NAME;
        case 4: // DBS
          return DBS;
        case 5: // BATCH_SAVE_NUM
          return BATCH_SAVE_NUM;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BATCHSAVENUM_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CRON_TIME, new org.apache.thrift.meta_data.FieldMetaData("cronTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DBS, new org.apache.thrift.meta_data.FieldMetaData("dbs", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CDB.class))));
    tmpMap.put(_Fields.BATCH_SAVE_NUM, new org.apache.thrift.meta_data.FieldMetaData("batchSaveNum", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CTask.class, metaDataMap);
  }

  public CTask() {
  }

  public CTask(
    String name,
    String cronTime,
    String userName,
    List<CDB> dbs,
    int batchSaveNum)
  {
    this();
    this.name = name;
    this.cronTime = cronTime;
    this.userName = userName;
    this.dbs = dbs;
    this.batchSaveNum = batchSaveNum;
    setBatchSaveNumIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CTask(CTask other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetCronTime()) {
      this.cronTime = other.cronTime;
    }
    if (other.isSetUserName()) {
      this.userName = other.userName;
    }
    if (other.isSetDbs()) {
      List<CDB> __this__dbs = new ArrayList<CDB>();
      for (CDB other_element : other.dbs) {
        __this__dbs.add(new CDB(other_element));
      }
      this.dbs = __this__dbs;
    }
    this.batchSaveNum = other.batchSaveNum;
  }

  public CTask deepCopy() {
    return new CTask(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.cronTime = null;
    this.userName = null;
    this.dbs = null;
    setBatchSaveNumIsSet(false);
    this.batchSaveNum = 0;
  }

  public String getName() {
    return this.name;
  }

  public CTask setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getCronTime() {
    return this.cronTime;
  }

  public CTask setCronTime(String cronTime) {
    this.cronTime = cronTime;
    return this;
  }

  public void unsetCronTime() {
    this.cronTime = null;
  }

  /** Returns true if field cronTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCronTime() {
    return this.cronTime != null;
  }

  public void setCronTimeIsSet(boolean value) {
    if (!value) {
      this.cronTime = null;
    }
  }

  public String getUserName() {
    return this.userName;
  }

  public CTask setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public void unsetUserName() {
    this.userName = null;
  }

  /** Returns true if field userName is set (has been assigned a value) and false otherwise */
  public boolean isSetUserName() {
    return this.userName != null;
  }

  public void setUserNameIsSet(boolean value) {
    if (!value) {
      this.userName = null;
    }
  }

  public int getDbsSize() {
    return (this.dbs == null) ? 0 : this.dbs.size();
  }

  public java.util.Iterator<CDB> getDbsIterator() {
    return (this.dbs == null) ? null : this.dbs.iterator();
  }

  public void addToDbs(CDB elem) {
    if (this.dbs == null) {
      this.dbs = new ArrayList<CDB>();
    }
    this.dbs.add(elem);
  }

  public List<CDB> getDbs() {
    return this.dbs;
  }

  public CTask setDbs(List<CDB> dbs) {
    this.dbs = dbs;
    return this;
  }

  public void unsetDbs() {
    this.dbs = null;
  }

  /** Returns true if field dbs is set (has been assigned a value) and false otherwise */
  public boolean isSetDbs() {
    return this.dbs != null;
  }

  public void setDbsIsSet(boolean value) {
    if (!value) {
      this.dbs = null;
    }
  }

  public int getBatchSaveNum() {
    return this.batchSaveNum;
  }

  public CTask setBatchSaveNum(int batchSaveNum) {
    this.batchSaveNum = batchSaveNum;
    setBatchSaveNumIsSet(true);
    return this;
  }

  public void unsetBatchSaveNum() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __BATCHSAVENUM_ISSET_ID);
  }

  /** Returns true if field batchSaveNum is set (has been assigned a value) and false otherwise */
  public boolean isSetBatchSaveNum() {
    return EncodingUtils.testBit(__isset_bitfield, __BATCHSAVENUM_ISSET_ID);
  }

  public void setBatchSaveNumIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __BATCHSAVENUM_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case CRON_TIME:
      if (value == null) {
        unsetCronTime();
      } else {
        setCronTime((String)value);
      }
      break;

    case USER_NAME:
      if (value == null) {
        unsetUserName();
      } else {
        setUserName((String)value);
      }
      break;

    case DBS:
      if (value == null) {
        unsetDbs();
      } else {
        setDbs((List<CDB>)value);
      }
      break;

    case BATCH_SAVE_NUM:
      if (value == null) {
        unsetBatchSaveNum();
      } else {
        setBatchSaveNum((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case CRON_TIME:
      return getCronTime();

    case USER_NAME:
      return getUserName();

    case DBS:
      return getDbs();

    case BATCH_SAVE_NUM:
      return Integer.valueOf(getBatchSaveNum());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case CRON_TIME:
      return isSetCronTime();
    case USER_NAME:
      return isSetUserName();
    case DBS:
      return isSetDbs();
    case BATCH_SAVE_NUM:
      return isSetBatchSaveNum();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CTask)
      return this.equals((CTask)that);
    return false;
  }

  public boolean equals(CTask that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_cronTime = true && this.isSetCronTime();
    boolean that_present_cronTime = true && that.isSetCronTime();
    if (this_present_cronTime || that_present_cronTime) {
      if (!(this_present_cronTime && that_present_cronTime))
        return false;
      if (!this.cronTime.equals(that.cronTime))
        return false;
    }

    boolean this_present_userName = true && this.isSetUserName();
    boolean that_present_userName = true && that.isSetUserName();
    if (this_present_userName || that_present_userName) {
      if (!(this_present_userName && that_present_userName))
        return false;
      if (!this.userName.equals(that.userName))
        return false;
    }

    boolean this_present_dbs = true && this.isSetDbs();
    boolean that_present_dbs = true && that.isSetDbs();
    if (this_present_dbs || that_present_dbs) {
      if (!(this_present_dbs && that_present_dbs))
        return false;
      if (!this.dbs.equals(that.dbs))
        return false;
    }

    boolean this_present_batchSaveNum = true;
    boolean that_present_batchSaveNum = true;
    if (this_present_batchSaveNum || that_present_batchSaveNum) {
      if (!(this_present_batchSaveNum && that_present_batchSaveNum))
        return false;
      if (this.batchSaveNum != that.batchSaveNum)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(CTask other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CTask typedOther = (CTask)other;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(typedOther.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, typedOther.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCronTime()).compareTo(typedOther.isSetCronTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCronTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cronTime, typedOther.cronTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserName()).compareTo(typedOther.isSetUserName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, typedOther.userName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDbs()).compareTo(typedOther.isSetDbs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDbs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbs, typedOther.dbs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBatchSaveNum()).compareTo(typedOther.isSetBatchSaveNum());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBatchSaveNum()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.batchSaveNum, typedOther.batchSaveNum);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CTask(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("cronTime:");
    if (this.cronTime == null) {
      sb.append("null");
    } else {
      sb.append(this.cronTime);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userName:");
    if (this.userName == null) {
      sb.append("null");
    } else {
      sb.append(this.userName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("dbs:");
    if (this.dbs == null) {
      sb.append("null");
    } else {
      sb.append(this.dbs);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("batchSaveNum:");
    sb.append(this.batchSaveNum);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CTaskStandardSchemeFactory implements SchemeFactory {
    public CTaskStandardScheme getScheme() {
      return new CTaskStandardScheme();
    }
  }

  private static class CTaskStandardScheme extends StandardScheme<CTask> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CTask struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CRON_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cronTime = iprot.readString();
              struct.setCronTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userName = iprot.readString();
              struct.setUserNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DBS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.dbs = new ArrayList<CDB>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  CDB _elem2; // required
                  _elem2 = new CDB();
                  _elem2.read(iprot);
                  struct.dbs.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setDbsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // BATCH_SAVE_NUM
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.batchSaveNum = iprot.readI32();
              struct.setBatchSaveNumIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CTask struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.cronTime != null) {
        oprot.writeFieldBegin(CRON_TIME_FIELD_DESC);
        oprot.writeString(struct.cronTime);
        oprot.writeFieldEnd();
      }
      if (struct.userName != null) {
        oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
        oprot.writeString(struct.userName);
        oprot.writeFieldEnd();
      }
      if (struct.dbs != null) {
        oprot.writeFieldBegin(DBS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.dbs.size()));
          for (CDB _iter3 : struct.dbs)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BATCH_SAVE_NUM_FIELD_DESC);
      oprot.writeI32(struct.batchSaveNum);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CTaskTupleSchemeFactory implements SchemeFactory {
    public CTaskTupleScheme getScheme() {
      return new CTaskTupleScheme();
    }
  }

  private static class CTaskTupleScheme extends TupleScheme<CTask> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CTask struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetCronTime()) {
        optionals.set(1);
      }
      if (struct.isSetUserName()) {
        optionals.set(2);
      }
      if (struct.isSetDbs()) {
        optionals.set(3);
      }
      if (struct.isSetBatchSaveNum()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetCronTime()) {
        oprot.writeString(struct.cronTime);
      }
      if (struct.isSetUserName()) {
        oprot.writeString(struct.userName);
      }
      if (struct.isSetDbs()) {
        {
          oprot.writeI32(struct.dbs.size());
          for (CDB _iter4 : struct.dbs)
          {
            _iter4.write(oprot);
          }
        }
      }
      if (struct.isSetBatchSaveNum()) {
        oprot.writeI32(struct.batchSaveNum);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CTask struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.cronTime = iprot.readString();
        struct.setCronTimeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.userName = iprot.readString();
        struct.setUserNameIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.dbs = new ArrayList<CDB>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            CDB _elem7; // required
            _elem7 = new CDB();
            _elem7.read(iprot);
            struct.dbs.add(_elem7);
          }
        }
        struct.setDbsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.batchSaveNum = iprot.readI32();
        struct.setBatchSaveNumIsSet(true);
      }
    }
  }

}

