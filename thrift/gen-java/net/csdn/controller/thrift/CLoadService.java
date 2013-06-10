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

public class CLoadService {

  public interface Iface {

    public void load(String prefix, String objectList) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void load(String prefix, String objectList, org.apache.thrift.async.AsyncMethodCallback<AsyncClient.load_call> resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public void load(String prefix, String objectList) throws org.apache.thrift.TException
    {
      send_load(prefix, objectList);
      recv_load();
    }

    public void send_load(String prefix, String objectList) throws org.apache.thrift.TException
    {
      load_args args = new load_args();
      args.setPrefix(prefix);
      args.setObjectList(objectList);
      sendBase("load", args);
    }

    public void recv_load() throws org.apache.thrift.TException
    {
      load_result result = new load_result();
      receiveBase(result, "load");
      return;
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void load(String prefix, String objectList, org.apache.thrift.async.AsyncMethodCallback<load_call> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      load_call method_call = new load_call(prefix, objectList, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class load_call extends org.apache.thrift.async.TAsyncMethodCall {
      private String prefix;
      private String objectList;
      public load_call(String prefix, String objectList, org.apache.thrift.async.AsyncMethodCallback<load_call> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.prefix = prefix;
        this.objectList = objectList;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("load", org.apache.thrift.protocol.TMessageType.CALL, 0));
        load_args args = new load_args();
        args.setPrefix(prefix);
        args.setObjectList(objectList);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public void getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        (new Client(prot)).recv_load();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("load", new load());
      return processMap;
    }

    public static class load<I extends Iface> extends org.apache.thrift.ProcessFunction<I, load_args> {
      public load() {
        super("load");
      }

      public load_args getEmptyArgsInstance() {
        return new load_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public load_result getResult(I iface, load_args args) throws org.apache.thrift.TException {
        load_result result = new load_result();
        iface.load(args.prefix, args.objectList);
        return result;
      }
    }

  }

  public static class load_args implements org.apache.thrift.TBase<load_args, load_args._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("load_args");

    private static final org.apache.thrift.protocol.TField PREFIX_FIELD_DESC = new org.apache.thrift.protocol.TField("prefix", org.apache.thrift.protocol.TType.STRING, (short)1);
    private static final org.apache.thrift.protocol.TField OBJECT_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("objectList", org.apache.thrift.protocol.TType.STRING, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new load_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new load_argsTupleSchemeFactory());
    }

    public String prefix; // required
    public String objectList; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      PREFIX((short)1, "prefix"),
      OBJECT_LIST((short)2, "objectList");

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
          case 1: // PREFIX
            return PREFIX;
          case 2: // OBJECT_LIST
            return OBJECT_LIST;
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
      tmpMap.put(_Fields.PREFIX, new org.apache.thrift.meta_data.FieldMetaData("prefix", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      tmpMap.put(_Fields.OBJECT_LIST, new org.apache.thrift.meta_data.FieldMetaData("objectList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(load_args.class, metaDataMap);
    }

    public load_args() {
    }

    public load_args(
      String prefix,
      String objectList)
    {
      this();
      this.prefix = prefix;
      this.objectList = objectList;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public load_args(load_args other) {
      if (other.isSetPrefix()) {
        this.prefix = other.prefix;
      }
      if (other.isSetObjectList()) {
        this.objectList = other.objectList;
      }
    }

    public load_args deepCopy() {
      return new load_args(this);
    }

    @Override
    public void clear() {
      this.prefix = null;
      this.objectList = null;
    }

    public String getPrefix() {
      return this.prefix;
    }

    public load_args setPrefix(String prefix) {
      this.prefix = prefix;
      return this;
    }

    public void unsetPrefix() {
      this.prefix = null;
    }

    /** Returns true if field prefix is set (has been assigned a value) and false otherwise */
    public boolean isSetPrefix() {
      return this.prefix != null;
    }

    public void setPrefixIsSet(boolean value) {
      if (!value) {
        this.prefix = null;
      }
    }

    public String getObjectList() {
      return this.objectList;
    }

    public load_args setObjectList(String objectList) {
      this.objectList = objectList;
      return this;
    }

    public void unsetObjectList() {
      this.objectList = null;
    }

    /** Returns true if field objectList is set (has been assigned a value) and false otherwise */
    public boolean isSetObjectList() {
      return this.objectList != null;
    }

    public void setObjectListIsSet(boolean value) {
      if (!value) {
        this.objectList = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case PREFIX:
        if (value == null) {
          unsetPrefix();
        } else {
          setPrefix((String)value);
        }
        break;

      case OBJECT_LIST:
        if (value == null) {
          unsetObjectList();
        } else {
          setObjectList((String)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case PREFIX:
        return getPrefix();

      case OBJECT_LIST:
        return getObjectList();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case PREFIX:
        return isSetPrefix();
      case OBJECT_LIST:
        return isSetObjectList();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof load_args)
        return this.equals((load_args)that);
      return false;
    }

    public boolean equals(load_args that) {
      if (that == null)
        return false;

      boolean this_present_prefix = true && this.isSetPrefix();
      boolean that_present_prefix = true && that.isSetPrefix();
      if (this_present_prefix || that_present_prefix) {
        if (!(this_present_prefix && that_present_prefix))
          return false;
        if (!this.prefix.equals(that.prefix))
          return false;
      }

      boolean this_present_objectList = true && this.isSetObjectList();
      boolean that_present_objectList = true && that.isSetObjectList();
      if (this_present_objectList || that_present_objectList) {
        if (!(this_present_objectList && that_present_objectList))
          return false;
        if (!this.objectList.equals(that.objectList))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(load_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      load_args typedOther = (load_args)other;

      lastComparison = Boolean.valueOf(isSetPrefix()).compareTo(typedOther.isSetPrefix());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetPrefix()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.prefix, typedOther.prefix);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetObjectList()).compareTo(typedOther.isSetObjectList());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetObjectList()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.objectList, typedOther.objectList);
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
      StringBuilder sb = new StringBuilder("load_args(");
      boolean first = true;

      sb.append("prefix:");
      if (this.prefix == null) {
        sb.append("null");
      } else {
        sb.append(this.prefix);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("objectList:");
      if (this.objectList == null) {
        sb.append("null");
      } else {
        sb.append(this.objectList);
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

    private static class load_argsStandardSchemeFactory implements SchemeFactory {
      public load_argsStandardScheme getScheme() {
        return new load_argsStandardScheme();
      }
    }

    private static class load_argsStandardScheme extends StandardScheme<load_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, load_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // PREFIX
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.prefix = iprot.readString();
                struct.setPrefixIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // OBJECT_LIST
              if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                struct.objectList = iprot.readString();
                struct.setObjectListIsSet(true);
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

      public void write(org.apache.thrift.protocol.TProtocol oprot, load_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.prefix != null) {
          oprot.writeFieldBegin(PREFIX_FIELD_DESC);
          oprot.writeString(struct.prefix);
          oprot.writeFieldEnd();
        }
        if (struct.objectList != null) {
          oprot.writeFieldBegin(OBJECT_LIST_FIELD_DESC);
          oprot.writeString(struct.objectList);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class load_argsTupleSchemeFactory implements SchemeFactory {
      public load_argsTupleScheme getScheme() {
        return new load_argsTupleScheme();
      }
    }

    private static class load_argsTupleScheme extends TupleScheme<load_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, load_args struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetPrefix()) {
          optionals.set(0);
        }
        if (struct.isSetObjectList()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetPrefix()) {
          oprot.writeString(struct.prefix);
        }
        if (struct.isSetObjectList()) {
          oprot.writeString(struct.objectList);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, load_args struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.prefix = iprot.readString();
          struct.setPrefixIsSet(true);
        }
        if (incoming.get(1)) {
          struct.objectList = iprot.readString();
          struct.setObjectListIsSet(true);
        }
      }
    }

  }

  public static class load_result implements org.apache.thrift.TBase<load_result, load_result._Fields>, java.io.Serializable, Cloneable   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("load_result");


    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new load_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new load_resultTupleSchemeFactory());
    }


    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
;

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
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(load_result.class, metaDataMap);
    }

    public load_result() {
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public load_result(load_result other) {
    }

    public load_result deepCopy() {
      return new load_result(this);
    }

    @Override
    public void clear() {
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof load_result)
        return this.equals((load_result)that);
      return false;
    }

    public boolean equals(load_result that) {
      if (that == null)
        return false;

      return true;
    }

    @Override
    public int hashCode() {
      return 0;
    }

    public int compareTo(load_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;
      load_result typedOther = (load_result)other;

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
      StringBuilder sb = new StringBuilder("load_result(");
      boolean first = true;

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

    private static class load_resultStandardSchemeFactory implements SchemeFactory {
      public load_resultStandardScheme getScheme() {
        return new load_resultStandardScheme();
      }
    }

    private static class load_resultStandardScheme extends StandardScheme<load_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, load_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, load_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class load_resultTupleSchemeFactory implements SchemeFactory {
      public load_resultTupleScheme getScheme() {
        return new load_resultTupleScheme();
      }
    }

    private static class load_resultTupleScheme extends TupleScheme<load_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, load_result struct) throws org.apache.thrift.TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, load_result struct) throws org.apache.thrift.TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
      }
    }

  }

}
