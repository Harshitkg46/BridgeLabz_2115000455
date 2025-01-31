class Circle
{
private double radius;
 public Circle(double radius){ 
this.radius=radius;
}
void calculateArea(){
double area=3.14*radius*radius;
System.out.println("Area: "+area);
}
void calculateCircum(){
double circum=2*3.14*radius;
System.out.println("Circumference: "+circum);
}
public static void main(String []args){
Circle circle=new Circle(7.5);
circle.calculateArea();
circle.calculateCircum();
}
}
