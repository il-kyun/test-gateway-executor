public class PlacePhone {
    private long placeNo;
    private long id;
    private long phone;

    public PlacePhone(long placeNo, long id, long phone) {
        this.placeNo = placeNo;
        this.id = id;
        this.phone = phone;
    }

    public long getPlaceNo() {
        return placeNo;
    }

    public void setPlaceNo(long placeNo) {
        this.placeNo = placeNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
