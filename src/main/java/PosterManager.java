public class PosterManager {
    private String[] movies = new String[0];
    private int countOfMovies = 5; // количество фильмов для вывода в обратном порядке по умолчанию

    public PosterManager() {
        this.countOfMovies = countOfMovies;
    }

    public PosterManager(int countOfMovies) {
        this.countOfMovies = countOfMovies;
    }

    public void add(String movie) { // метод добавления нового фильма
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() { // вывод всех фильмов
        return movies;
    }

    public String[] findLast() { // вывод фильмов в обратном от добавления порядке
        int resultLength;
        if (countOfMovies < movies.length) {
            resultLength = countOfMovies;
        } else {
            resultLength = movies.length;
        }
        String[] reversed = new String[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = movies[movies.length - 1 - i];
        }

        return reversed;
    }
}
