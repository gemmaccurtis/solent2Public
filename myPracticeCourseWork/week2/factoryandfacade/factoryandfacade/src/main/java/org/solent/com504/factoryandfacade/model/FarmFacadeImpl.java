/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 4curtg91
 */
public class FarmFacadeImpl implements FarmFacade {

    List<Animal> animals = new ArrayList<Animal>();
    
    
    @Override
    public List<Animal> getAllAnimals() {
       return new ArrayList(animals);
    }

    @Override
    public void addDog(String name) {
        Dog dog = new Dog();
        dog.setName(name);
        animals.add(dog);
    
    }

    @Override
    public void addCat(String name) {
        Cat cat = new Cat();
        cat.setName(name);
        animals.add(cat);
    }

    @Override
    public void addCow(String name) {
        Cow cow = new Cow();
        cow.setName(name);
        animals.add(cow);
    }
    
}
