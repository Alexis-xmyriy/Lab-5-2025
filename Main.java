import functions.*;
import functions.basic.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование методов Object для табулированных функций ===");
        
        System.out.println("\n--- Задание 1: FunctionPoint ---");
        testFunctionPoint();
        
        System.out.println("\n--- Задание 2: ArrayTabulatedFunction ---");
        testArrayTabulatedFunction();
        
        System.out.println("\n--- Задание 3: LinkedListTabulatedFunction ---");
        testLinkedListTabulatedFunction();
        
        System.out.println("\n--- Задание 4-5: Сравнение и клонирование ---");
        testComparisonAndCloning();
    }
    
    private static void testFunctionPoint() {
        FunctionPoint p1 = new FunctionPoint(1.0, 2.0);
        FunctionPoint p2 = new FunctionPoint(1.0, 2.0);
        FunctionPoint p3 = new FunctionPoint(2.0, 3.0);
        
        System.out.println("1. toString():");
        System.out.println("   p1 = " + p1.toString());
        System.out.println("   p2 = " + p2.toString());
        
        System.out.println("\n2. equals():");
        System.out.println("   p1.equals(p2) = " + p1.equals(p2));
        System.out.println("   p1.equals(p3) = " + p1.equals(p3));
        
        System.out.println("\n3. hashCode():");
        System.out.println("   p1.hashCode() = " + p1.hashCode());
        System.out.println("   p2.hashCode() = " + p2.hashCode());
        System.out.println("   p3.hashCode() = " + p3.hashCode());
        
        System.out.println("\n4. clone():");
        FunctionPoint p1Clone = (FunctionPoint) p1.clone();
        System.out.println("   p1.clone() = " + p1Clone);
        System.out.println("   p1 == p1.clone() = " + (p1 == p1Clone));
        System.out.println("   p1.equals(p1.clone()) = " + p1.equals(p1Clone));
    }
    
    private static void testArrayTabulatedFunction() {
        System.out.println("1. Создание функций и toString():");
        
        FunctionPoint[] points = {
            new FunctionPoint(0, 0),
            new FunctionPoint(1, 1),
            new FunctionPoint(2, 4)
        };
        
        ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(points);
        ArrayTabulatedFunction func2 = new ArrayTabulatedFunction(points);
        
        System.out.println("   func1 = " + func1.toString());
        System.out.println("   func2 = " + func2.toString());
        
        System.out.println("\n2. equals():");
        System.out.println("   func1.equals(func2) = " + func1.equals(func2));
        
        ArrayTabulatedFunction func3 = new ArrayTabulatedFunction(0, 2, 3);
        System.out.println("   func1.equals(func3) = " + func1.equals(func3));
        
        System.out.println("\n3. hashCode():");
        System.out.println("   func1.hashCode() = " + func1.hashCode());
        System.out.println("   func2.hashCode() = " + func2.hashCode());
        System.out.println("   func3.hashCode() = " + func3.hashCode());
        
        System.out.println("\n4. clone() и глубокое клонирование:");
        ArrayTabulatedFunction clone = (ArrayTabulatedFunction) func1.clone();
        System.out.println("   clone = " + clone.toString());
        
        // Изменяем оригинал
        func1.setPointY(1, 100);
        System.out.println("   После изменения func1[1].y = 100:");
        System.out.println("   func1 = " + func1.toString());
        System.out.println("   clone = " + clone.toString());
        System.out.println("   func1.equals(clone) = " + func1.equals(clone));
    }
    
    private static void testLinkedListTabulatedFunction() {
        System.out.println("1. Создание функций и toString():");
        
        FunctionPoint[] points = {
            new FunctionPoint(0, 0),
            new FunctionPoint(1, 1),
            new FunctionPoint(2, 4)
        };
        
        LinkedListTabulatedFunction func1 = new LinkedListTabulatedFunction(points);
        LinkedListTabulatedFunction func2 = new LinkedListTabulatedFunction(points);
        
        System.out.println("   func1 = " + func1.toString());
        System.out.println("   func2 = " + func2.toString());
        
        System.out.println("\n2. equals():");
        System.out.println("   func1.equals(func2) = " + func1.equals(func2));
        
        System.out.println("\n3. hashCode():");
        System.out.println("   func1.hashCode() = " + func1.hashCode());
        System.out.println("   func2.hashCode() = " + func2.hashCode());
        
        System.out.println("\n4. clone() и глубокое клонирование:");
        LinkedListTabulatedFunction clone = (LinkedListTabulatedFunction) func1.clone();
        System.out.println("   clone = " + clone.toString());
        
        // Изменяем оригинал
        func1.setPointY(1, 200);
        System.out.println("   После изменения func1[1].y = 200:");
        System.out.println("   func1 = " + func1.toString());
        System.out.println("   clone = " + clone.toString());
        System.out.println("   func1.equals(clone) = " + func1.equals(clone));
    }
    
    private static void testComparisonAndCloning() {
        System.out.println("1. Сравнение разных реализаций:");
        
        // Создаем одинаковые функции разными способами
        FunctionPoint[] points = {
            new FunctionPoint(0, 0),
            new FunctionPoint(1, 1),
            new FunctionPoint(2, 4)
        };
        
        ArrayTabulatedFunction arrayFunc = new ArrayTabulatedFunction(points);
        LinkedListTabulatedFunction listFunc = new LinkedListTabulatedFunction(points);
        
        System.out.println("   arrayFunc = " + arrayFunc.toString());
        System.out.println("   listFunc  = " + listFunc.toString());
        System.out.println("   arrayFunc.equals(listFunc) = " + arrayFunc.equals(listFunc));
        
        System.out.println("\n2. Согласованность equals() и hashCode():");
        System.out.println("   arrayFunc.hashCode() = " + arrayFunc.hashCode());
        System.out.println("   listFunc.hashCode()  = " + listFunc.hashCode());
        
        System.out.println("\n3. Проверка изменения хэш-кода при небольшом изменении:");
        System.out.println("   arrayFunc.hashCode() (исходный) = " + arrayFunc.hashCode());
        
        // Меняем немного значение
        arrayFunc.setPointY(1, arrayFunc.getPointY(1) + 0.001);
        System.out.println("   arrayFunc.hashCode() (после +0.001) = " + arrayFunc.hashCode());
        
        System.out.println("\n4. Проверка метода clone() в интерфейсе:");
        TabulatedFunction tabFunc = arrayFunc; // через интерфейс
        TabulatedFunction cloned = (TabulatedFunction) tabFunc.clone();
        System.out.println("   tabFunc через интерфейс = " + tabFunc.toString());
        System.out.println("   cloned через интерфейс  = " + cloned.toString());
    }
}