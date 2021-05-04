package DoublyCircularLinkedList;

import java.util.Scanner;

public class DoublyCircularLinkedList {

        public static class LinkedList {

            static class Main{
                static Node head;
                static Node last;

                static class Node{
                    int data;
                    Node next;
                    Node prev;
                };

                static void addNode(int value) {

                    if (head == null) {
                        Node new_node = new Node();
                        new_node.data = value;
                        new_node.next = new_node.prev = new_node;
                        head = new_node;
                        return;
                    }

                    last = (head).prev;
                    Node new_node = new Node();
                    new_node.data = value;
                    new_node.next = head;
                    (head).prev = new_node;
                    new_node.prev = last;
                    last.next = new_node;
                }

                static void insertAfter(int key1 , int key2){
                    Node new_node2 = new Node();
                    Node temp = head;
                    while (temp.data != key1)
                        temp = temp.next;

                    new_node2.next = temp.next;
                    temp.next.prev = new_node2;
                    new_node2.prev = temp;
                    temp.next= new_node2;
                    new_node2.data = key2;
                    Node temp2 = head;
                    while (temp2.next != head)
                    {
                        System.out.printf("%d ", temp2.data);
                        temp2 = temp2.next;
                    }
                    System.out.printf("%d ", temp2.data);

                }

                static void printNodes()   {
                    Node temp = head;

                    while (temp.next != head)
                    {
                        System.out.printf("%d ", temp.data);
                        temp = temp.next;
                    }
                    System.out.printf("%d ", temp.data);
                }

                public static void main(String[] args) {

                    System.out.println("Lütfen düğüm adeti girin: ");
                    Scanner scn = new Scanner(System.in);
                    int count = scn.nextInt();
                    for (int i = 0; i < count; i++) {
                        int sayi = (int) (Math.random() * 100 + 1);
                        addNode(sayi);
                    }
                    printNodes();
                    System.out.println("\nHangi sayıdan sonra ekeleneceğini girin: ");
                    int key1 = scn.nextInt();
                    Node temp = head;

                    while (temp.next != head) {

                        temp = temp.next;
                        if (temp.data == key1){
                            System.out.println("Eklenecek sayıyı girin: ");
                            int key2 = scn.nextInt();
                            System.out.printf("Listenin son hali: \n");
                            insertAfter(key1, key2);
                        }else {
                            System.out.println("Geçersiz sayı");
                            break;
                        }

                    }

                }
            }

        }
    }


