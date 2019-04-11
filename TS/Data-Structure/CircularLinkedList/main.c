/*
 * main.c
 *
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 */

#include "stdlib.h"
#include <stdio.h>

struct Node
{
	int data;
	struct Node *next;
};

// Size of linked list
int size = 0;

// Defining Prototypes (Used functions for Circular Linked List)
void printList (struct Node *);
void push_first (struct Node **, int);
struct Node* removeLastNode(struct Node *);

int main (){

	struct Node* head = NULL;

	push_first (&head, 5);
	push_first (&head, 4);
	push_first (&head, 3);
	push_first (&head, 2);
	push_first (&head, 1);

	removeLastNode (head);
	removeLastNode (head);
	removeLastNode (head);
	printList(head);
	return 0;
}

/* Given a reference (pointer to pointer) to the head of a list and an int, inserts a new node on the front of the list. */
void push_first (struct Node **head, int val){

	/* 1. allocate node */
	struct Node *new_node = (struct Node*) malloc (sizeof (struct Node));

	/* 2. put in the data */
	new_node -> data = val;

	/* 3. Make next of new node as head */
	new_node -> next = *head;

	/* 4. change prev of head node to new node */
	if (*head != NULL) {

		/* If linked list is not NULL then set the next of last node */
		struct Node *temp = *head;

		while (temp -> next != *head)
			temp = temp -> next;

		temp -> next = new_node;
	}
	else
		new_node -> next = new_node; /*For the first node */

	/* 5. move the head to point to the new node */
	*head = new_node;

	size++;
}


/* Function to remove the last node of the linked list */
struct Node* removeLastNode(struct Node* head) {

	if (head == NULL)
		return NULL;

	if (head->next == head) {
		free (head);
		return NULL;
	}

	// Find the second last node
	struct Node *second_last = head;

	while (second_last->next->next != head)
		second_last = second_last->next;

	// Delete last node
	free (second_last->next);

	// Change next of second last
	second_last->next = head;

	size --;
	return head;
}

void printList (struct Node *head) {

	struct Node *temp = head;

	if (head != NULL){
		do {
			printf("%d ", temp -> data); 
			temp = temp -> next;
		} while (temp != head);
	}
	printf("\n");
}


