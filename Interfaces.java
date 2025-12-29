
// public class Interfaces {

//     public static void main(String[] args) {
//         // Car car = new Car();
//         // car.acc();
//         // car.start();
//         // car.stop();
//         // car.brake();
//         // System.out.println(car.price);
//         // Engine car1 = new Car();
//         // car1.acc();
//         // car1.start();
//         // car1.stop();
//         // // System.out.println(car1.a);  error------------>>>>>>
//         // Media carMedia = new Car();
//         // carMedia.stop();
//         NiceCar car = new NiceCar();
//         car.start();
//         car.startMusic();
//         car.upgradeEngine();
//         car.start();
//     }
// }

// // class Car implements Engine, Brake, Media {

// //     // int a = 10;
// //     @Override
// //     public void start() {
// //         System.out.println("I start engine like a Normal Car");
// //     }

// //     @Override
// //     public void stop() {
// //         System.out.println("I stop engine like a Normal Car");
// //     }

// //     @Override
// //     public void acc() {
// //         System.out.println("I acclerate like a Normal Car");
// //     }

// //     @Override
// //     public void brake() {
// //         System.out.println("I brake like a Normal Car");
// //     }
// // }

// class CDPlayer implements Media {

//     @Override
//     public void start() {
//         System.out.println("Music Start");
//     }

//     @Override
//     public void stop() {
//         System.out.println("Music Stop");
//     }

// }

// class PowerEngine implements Engine {

//     @Override
//     public void start() {
//         System.out.println("Power Engine Starts");
//     }

//     @Override
//     public void stop() {
//         System.out.println("Power Engine Stops");
//     }

//     @Override
//     public void acc() {
//         System.out.println("Power Engine Accelerates");
//     }

// }

// class ElectricEngine implements Engine {

//     @Override
//     public void start() {
//         System.out.println("Electric Engine Starts");
//     }

//     @Override
//     public void stop() {
//         System.out.println("Electric Engine Stops");
//     }

//     @Override
//     public void acc() {
//         System.out.println("Electric Engine Accelerates");
//     }
// }

// class NiceCar {

//     private Engine engine;
//     private Media player = new CDPlayer();

//     public NiceCar() {
//         engine = new PowerEngine();
//     }

//     public NiceCar(Engine engine) {
//         this.engine = engine;
//     }

//     void start() {
//         engine.start();
//     }

//     void stop() {
//         engine.stop();
//     }

//     void startMusic() {
//         player.start();
//     }

//     void stopMusic() {
//         player.stop();
//     }

//     void upgradeEngine() {
//         this.engine = new ElectricEngine();
//     }
// }

// interface Engine {

//     int price = 799999;

//     void start();

//     void stop();

//     void acc();
// }

// interface Brake {

//     void brake();

//     void start();
// }

// interface Media {

//     void start();

//     void stop();
// }
