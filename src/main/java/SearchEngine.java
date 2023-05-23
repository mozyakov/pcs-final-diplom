import java.util.List;

//Этот интерфейс описывает методы поискового движка
public interface SearchEngine {
    List<PageEntry> search(String[] word);
}