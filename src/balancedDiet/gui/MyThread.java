package balancedDiet.gui;

class MyThread extends Thread{
    @Override
    public void run(){
        new Loading();
        Loading.panel.add(Loading.f);
        Loading.frame.add(Loading.panel);
        Loading.frame.setVisible(true);
    }
}