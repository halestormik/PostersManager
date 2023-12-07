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

        for (int i = 1; i <= 6; i++) { // добавим 6 фильмов
            String iToString = String.valueOf(i); // перевод счетчика цикла в строку, чтобы добавить в название фильма
            manager.add("Movie " + iToString);
        }

        String[] expected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6",};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReverse() { // вывести афишу в обратном порядке, если количество фильмов равно 5 (по умолчанию)
        PosterManager manager = new PosterManager();

        for (int i = 1; i <= 5; i++) { // добавим 5 фильмов
            String iToString = String.valueOf(i); // перевод счетчика цикла в строку,  чтобы добавить в название фильма
            manager.add("Movie " + iToString);
        }

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayReversedIfZeroMovies() { // проверка работы метода обратного вывода, если фильмов в афише нет
        PosterManager manager = new PosterManager(0);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayreversedIfCountBelowDefault() { // вывод афиши в обратном порядке, если запрошено фильмов меньше, чем добавлено
        PosterManager manager = new PosterManager(3);

        for (int i = 1; i <= 5; i++) { // добавим 5 фильмов
            String iToString = String.valueOf(i); // перевод счетчика цикла в строку,  чтобы добавить в название фильма
            manager.add("Movie " + iToString);
        }

        String[] expected = {"Movie 5", "Movie 4", "Movie 3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayreversedIfCountAboveDefault() { // вывод афиши в обратном порядке, если запрошено фильмов больше, чем добавлено
        PosterManager manager = new PosterManager(8);

        for (int i = 1; i <= 5; i++) { // добавим 5 фильмов
            String iToString = String.valueOf(i); // перевод счетчика цикла в строку,  чтобы добавить в название фильма
            manager.add("Movie " + iToString);
        }

        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
