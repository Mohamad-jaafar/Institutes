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
	struct Node *prev;
};

// Size of linked list
int size = 0;

// Defining Prototypes (Used functions for Double Linked List)
void printList (struct Node *);
void push_first (struct Node **, int);
void push_last(struct Node **, int);
void removeLastNode(struct Node **, struct Node *);

int main (){

	struct Node* head = NULL;

	push_first (&head, 5);
	push_first (&head, 4);
	push_first (&head, 3);
	push_first (&head, 2);
	push_first (&head, 1);
	push_last (&head, 6);
	push_last (&head, 7);
	push_last (&head, 8);
	push_last (&head, 9);
	removeLastNode (&head, head); /* delete first node */
	removeLastNode (&head, head); /* delete next node */
	removeLastNode (&head, head -> next); /* delete fourth node */
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
	new_node -> prev = NULL; 

	/* 4. change prev of head node to new node */
	if (*head != NULL)
		(*head) -> prev = new_node;

	/* 5. move the head to point to the new node */
	*head = new_node;

	size++;
}

/* Given a reference (pointer to pointer) to the head of a list and an int, appends a new node at the end */
void push_last(struct Node **head, int val){
	/* 1. allocate node */
	struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));

	struct Node *last = *head; /* used in step 5*/

	/* 2. put in the data */
	new_node->data = val;

	/* 3. This new node is going to be the last node, so make next of
	 it as NULL*/
	new_node->next = NULL;

	/* 4. If the Linked List is empty, then make the new node as head */
	if (*head == NULL) {

		new_node -> prev = NULL; 
		*head = new_node;
		return;
	}

	/* 5. Else traverse till the last node */
	while (last->next != NULL)
		last = last->next;

	/* 6. Change the next of last node */
	last->next = new_node;

	/* 7. Make last node as previous of new node */
	new_node->prev = last;

	size++;
}

/* Function to remove the last node of the double linked list */
void removeLastNode(struct Node** head_ref, struct Node* del) {

	/* base case */
	if (*head_ref == NULL || del == NULL) 
		return; 

	/* If node to be deleted is head node */
	if (*head_ref == del) 
		*head_ref = del->next; 

	/* Change next only if node to be deleted is NOT the last node */
	if (del->next != NULL) 
		del->next->prev = del->prev; 

	/* Change prev only if node to be deleted is NOT the first node */
	if (del->prev != NULL) 
		del->prev->next = del->next; 

	/* Finally, free the memory occupied by del*/
	free(del); 
	return; 
}

void printList (struct Node *n) {

	while (n != NULL) {
		printf(" %d ", n -> data);
		n = n -> next;
	}
	printf("\n");
}


