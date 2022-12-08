package service;

import product.Shoe;

import java.util.List;

public interface ShoeService {
    List<Shoe> findAll();
    void add(Shoe shoe);
    Shoe findById(int id);
    List<Shoe> findByName(String name);
    void update(int id, Shoe shoe);
    void remove(int id);
    List<Shoe> sortByPrice();
    List<Shoe> sortReduction();
}
