package uqac.dim.appinfomobile;

public class Film {
    public String realisator;
    public String title;
    public String type;
    public String picture = "https://en.wikipedia.org/wiki/Jurassic_World_Dominion#/media/File:JurassicWorldDominion_Poster.jpeg";

    public Film(String realisator, String title, String type, String picture){
        this.realisator=realisator;
        this.title=title;
        this.type=type;
        if(picture != null) this.picture=picture;
    }

    
}
