import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldAddMovie() { // тест на добавление нового фильма, тест на вывод афиши из 1 фильма
        PosterManager manager = new PosterManager();

        manager.add("Movie 1");

        String[] expected = {"Movie 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayMovieIfNotAdded() { // показать афишу, если фильмы не добавлены
        PosterManager manager = new PosterManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayMoviesIf6Added() { // показать афишу с добавленными последовательно шестью фильмами
        PosterManager manager = new PosterManager();

        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        manager.add("Movie 5");
        manager.add("Movie 6");

        String[] expected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6",};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverse() { // вывести афишу в обратном порядке, если количество фильмов равно 5 (по умолчанию)
        PosterManager manager = new PosterManager();

        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        manager.add("Movie 5");

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayreversedIfCountBelowDefault() { // вывод афиши в обратном порядке, если запрошено фильмов меньше, чем добавлено
        PosterManager manager = new PosterManager(3);

        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        manager.add("Movie 5");

        String[] expected = {"Movie 5", "Movie 4", "Movie 3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayreversedIfCountAboveDefault() { // вывод афиши в обратном порядке, если запрошено фильмов больше, чем добавлено
        PosterManager manager = new PosterManager(8);

        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        manager.add("Movie 5");

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
