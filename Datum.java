public class Datum {
    int tag;
    int monat;
    int jahr;

    // Konstruktor parsed String in Datum-Objekt
    public Datum(String date)   {
        this.tag = Integer.parseInt(date.substring(0,2));
        this.monat = Integer.parseInt(date.substring(3,5));
        this.jahr = Integer.parseInt(date.substring(6,8));
    }

    public String getTTMM4LETTERS()   {
        String date = "";
        if(this.tag<10) {
            date = date + "0" + this.tag;
        }
        else{
            date = date + this.tag;
        }
        if(this.monat<10) {
            date = date + "0" + this.monat;
        }
        else{
            date = date + this.monat;
        }

        return date;
    } 

    // GETTER/SETTER
    public int getTag() {
        return tag;
    }
    public void setTag(int tag) {
        this.tag = tag;
    }
    public int getMonat() {
        return monat;
    }
    public void setMonat(int monat) {
        this.monat = monat;
    }
    public int getJahr() {
        return jahr;
    }
    public void setJahr(int jahr) {
        this.jahr = jahr;
    }
    
    public String getDateAsString() {
    
      String date = "";
      if(this.tag<10) {
            date = date + "0" + this.tag;
      }
      
      else{
            date = date + this.tag;
      }
      
      date += ".";
      if(this.monat<10) {
            date = date + "0" + this.monat;
      }
      
      else {
            date = date + this.monat;
      }
      date += ".";
      
      if(this.jahr<10) {
            date = date + "0" + this.jahr;
      }
      
      else {
            date = date + this.jahr;
      }
      
        

        return date;
      

             
    }


}
