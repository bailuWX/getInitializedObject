
/**
 * 测试用的实体类
 */
public class StatusDto {
    /**
     * Data name
     */
    private String dataName;

    private String status;

    private byte b1;

    private Byte annByte;

    private short s1;

    private Short annShort;

    private int i1;

    private Integer annInteger;

    private long l1;

    private Long annLong;

    private float f1;

    private Float annFloat;

    private double d1;

    private Double annDouble;

    private char c1;

    public byte getB1() {
        return b1;
    }

    public void setB1(byte b1) {
        this.b1 = b1;
    }

    public Byte getAnnByte() {
        return annByte;
    }

    public void setAnnByte(Byte annByte) {
        this.annByte = annByte;
    }

    public short getS1() {
        return s1;
    }

    public void setS1(short s1) {
        this.s1 = s1;
    }

    public Short getAnnShort() {
        return annShort;
    }

    public void setAnnShort(Short annShort) {
        this.annShort = annShort;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public Integer getAnnInteger() {
        return annInteger;
    }

    public void setAnnInteger(Integer annInteger) {
        this.annInteger = annInteger;
    }

    public long getL1() {
        return l1;
    }

    public void setL1(long l1) {
        this.l1 = l1;
    }

    public Long getAnnLong() {
        return annLong;
    }

    public void setAnnLong(Long annLong) {
        this.annLong = annLong;
    }

    public float getF1() {
        return f1;
    }

    public void setF1(float f1) {
        this.f1 = f1;
    }

    public Float getAnnFloat() {
        return annFloat;
    }

    public void setAnnFloat(Float annFloat) {
        this.annFloat = annFloat;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public Double getAnnDouble() {
        return annDouble;
    }

    public void setAnnDouble(Double annDouble) {
        this.annDouble = annDouble;
    }

    public char getC1() {
        return c1;
    }

    public void setC1(char c1) {
        this.c1 = c1;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public boolean isAnnBool() {
        return annBool;
    }

    public void setAnnBool(boolean annBool) {
        this.annBool = annBool;
    }

    public Boolean getAnnBoolean() {
        return annBoolean;
    }

    public void setAnnBoolean(Boolean annBoolean) {
        this.annBoolean = annBoolean;
    }

    private Character character;

    private boolean annBool;

    private Boolean annBoolean;

    @Override
    public String toString() {
        return "StatusDto{" + "dataName='" + dataName + '\'' + ", status='" + status + '\'' + ", b1=" + b1
            + ", annByte=" + annByte + ", s1=" + s1 + ", annShort=" + annShort + ", i1=" + i1 + ", annInteger="
            + annInteger + ", l1=" + l1 + ", annLong=" + annLong + ", f1=" + f1 + ", annFloat=" + annFloat + ", d1="
            + d1 + ", annDouble=" + annDouble + ", c1=" + c1 + ", character=" + character + ", annBool=" + annBool
            + ", annBoolean=" + annBoolean + '}';
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
