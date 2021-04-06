package lab.pm.data;

@FunctionalInterface
public interface Ratable<T> {
    public static final Rating  DEFAULT_RATING = Rating.NOT_RATED;

    T applyRating(Rating rating);

    public default Rating getRating(){
        return DEFAULT_RATING;
    }

    public default T applyRating(int stars){
        return applyRating(Ratable.covert(stars));
    }

    public static Rating covert(int stars){
        return (stars >=0  && stars<=5)? Rating.values()[stars]: Rating.NOT_RATED;
    }
}
