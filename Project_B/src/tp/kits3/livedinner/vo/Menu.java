package tp.kits3.livedinner.vo;

public class Menu {

    private Integer muid;

    private Integer ctgid;

    private String muname;

    private String intro;

    private String details;

    private Double price;

    private String currency;

    public Integer getMuid() {
        return muid;
    }

    public void setMuid(Integer muid) {
        this.muid = muid;
    }

    public Integer getCtgid() {
        return ctgid;
    }

    public void setCtgid(Integer ctgid) {
        this.ctgid = ctgid;
    }

    public String getMuname() {
        return muname;
    }

    public void setMuname(String muname) {
        this.muname = muname;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Menu ëª¨ë�¸ ë³µì‚¬
    public void CopyData(Menu param)
    {
        this.muid = param.getMuid();
        this.ctgid = param.getCtgid();
        this.muname = param.getMuname();
        this.intro = param.getIntro();
        this.details = param.getDetails();
        this.price = param.getPrice();
        this.currency = param.getCurrency();
    }
}