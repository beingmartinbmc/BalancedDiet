package balancedDiet.gui;

import balancedDiet.meals.Meals;

class MyAnotherThread implements Runnable{
    @Override
    public void run(){
        MyThread t=new MyThread();
        try {
            t.join();
            t.start();
            Thread.currentThread().sleep(4000);
            new Meals();
            Loading.frame.dispose();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
