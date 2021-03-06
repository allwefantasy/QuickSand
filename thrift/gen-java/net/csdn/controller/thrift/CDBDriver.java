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

public class CDBDriver implements org.apache.thrift.TBase<CDBDriver, CDBDriver._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CDBDriver");

  private static final org.apache.thrift.protocol.TField DRIVER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("driverName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField URL_FIELD_DESC = new org.apache.thrift.protocol.TField("url", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CDBDriverStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CDBDriverTupleSchemeFactory());
  }

  public String driverName; // required
  public String url; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DRIVER_NAME((short)1, "driverName"),
    URL((short)2, "url");

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
        case 1: // DRIVER_NAME
          return DRIVER_NAME;
        case 2: // URL
          return URL;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DRIVER_NAME, new org.apache.thrift.meta_data.FieldMetaData("driverName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.URL, new org.apache.thrift.meta_data.FieldMetaData("url", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CDBDriver.class, metaDataMap);
  }

  public CDBDriver() {
  }

  public CDBDriver(
    String driverName,
    String url)
  {
    this();
    this.driverName = driverName;
    this.url = url;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CDBDriver(CDBDriver other) {
    if (other.isSetDriverName()) {
      this.driverName = other.driverName;
    }
    if (other.isSetUrl()) {
      this.url = other.url;
    }
  }

  public CDBDriver deepCopy() {
    return new CDBDriver(this);
  }

  @Override
  public void clear() {
    this.driverName = null;
    this.url = null;
  }

  public String getDriverName() {
    return this.driverName;
  }

  public CDBDriver setDriverName(String driverName) {
    this.driverName = driverName;
    return this;
  }

  public void unsetDriverName() {
    this.driverName = null;
  }

  /** Returns true if field driverName is set (has been assigned a value) and false otherwise */
  public boolean isSetDriverName() {
    return this.driverName != null;
  }

  public void setDriverNameIsSet(boolean value) {
    if (!value) {
      this.driverName = null;
    }
  }

  public String getUrl() {
    return this.url;
  }

  public CDBDriver setUrl(String url) {
    this.url = url;
    return this;
  }

  public void unsetUrl() {
    this.url = null;
  }

  /** Returns true if field url is set (has been assigned a value) and false otherwise */
  public boolean isSetUrl() {
    return this.url != null;
  }

  public void setUrlIsSet(boolean value) {
    if (!value) {
      this.url = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case DRIVER_NAME:
      if (value == null) {
        unsetDriverName();
      } else {
        setDriverName((String)value);
      }
      break;

    case URL:
      if (value == null) {
        unsetUrl();
      } else {
        setUrl((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DRIVER_NAME:
      return getDriverName();

    case URL:
      return getUrl();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DRIVER_NAME:
      return isSetDriverName();
    case URL:
      return isSetUrl();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CDBDriver)
      return this.equals((CDBDriver)that);
    return false;
  }

  public boolean equals(CDBDriver that) {
    if (that == null)
      return false;

    boolean this_present_driverName = true && this.isSetDriverName();
    boolean that_present_driverName = true && that.isSetDriverName();
    if (this_present_driverName || that_present_driverName) {
      if (!(this_present_driverName && that_present_driverName))
        return false;
      if (!this.driverName.equals(that.driverName))
        return false;
    }

    boolean this_present_url = true && this.isSetUrl();
    boolean that_present_url = true && that.isSetUrl();
    if (this_present_url || that_present_url) {
      if (!(this_present_url && that_present_url))
        return false;
      if (!this.url.equals(that.url))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(CDBDriver other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    CDBDriver typedOther = (CDBDriver)other;

    lastComparison = Boolean.valueOf(isSetDriverName()).compareTo(typedOther.isSetDriverName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDriverName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.driverName, typedOther.driverName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUrl()).compareTo(typedOther.isSetUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.url, typedOther.url);
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
    StringBuilder sb = new StringBuilder("CDBDriver(");
    boolean first = true;

    sb.append("driverName:");
    if (this.driverName == null) {
      sb.append("null");
    } else {
      sb.append(this.driverName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("url:");
    if (this.url == null) {
      sb.append("null");
    } else {
      sb.append(this.url);
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CDBDriverStandardSchemeFactory implements SchemeFactory {
    public CDBDriverStandardScheme getScheme() {
      return new CDBDriverStandardScheme();
    }
  }

  private static class CDBDriverStandardScheme extends StandardScheme<CDBDriver> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CDBDriver struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DRIVER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.driverName = iprot.readString();
              struct.setDriverNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.url = iprot.readString();
              struct.setUrlIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, CDBDriver struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.driverName != null) {
        oprot.writeFieldBegin(DRIVER_NAME_FIELD_DESC);
        oprot.writeString(struct.driverName);
        oprot.writeFieldEnd();
      }
      if (struct.url != null) {
        oprot.writeFieldBegin(URL_FIELD_DESC);
        oprot.writeString(struct.url);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CDBDriverTupleSchemeFactory implements SchemeFactory {
    public CDBDriverTupleScheme getScheme() {
      return new CDBDriverTupleScheme();
    }
  }

  private static class CDBDriverTupleScheme extends TupleScheme<CDBDriver> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CDBDriver struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetDriverName()) {
        optionals.set(0);
      }
      if (struct.isSetUrl()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetDriverName()) {
        oprot.writeString(struct.driverName);
      }
      if (struct.isSetUrl()) {
        oprot.writeString(struct.url);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CDBDriver struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.driverName = iprot.readString();
        struct.setDriverNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.url = iprot.readString();
        struct.setUrlIsSet(true);
      }
    }
  }

}

