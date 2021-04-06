package lab.pm.data;

import static lab.pm.data.Symbols.*;

public enum Rating {

    NOT_RATED(W_STR+W_STR+W_STR+W_STR+W_STR),
    ONE_STAR(B_STR+W_STR+W_STR+W_STR+W_STR),
    TWO_START(B_STR+B_STR+W_STR+W_STR+W_STR),
    THREE_STAR(B_STR+B_STR+B_STR+W_STR+W_STR),
    FOUR_STAR(B_STR+B_STR+B_STR+B_STR+W_STR),
    FIVE_STAR(B_STR+B_STR+B_STR+B_STR+B_STR);

    private String stars;

    Rating(String stars){
        this.stars = stars;
    }
    public String getStars(){
        return this.stars;
    }

}
