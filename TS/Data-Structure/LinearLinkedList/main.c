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

// Defining Prototypes (Used functions for Linear Linked List)
void printList (struct Node *);
void push_first (struct Node **, int);
void push_last(struct Node **, int);
void push_on_position (struct Node **, int, int);
struct Node* removeLastNode(struct Node *);

int main (){

	struct Node* head = NULL;

	push_first (&head, 5);
	push_first (&head, 4);
	push_first (&head, 3);
	push_first (&head, 2);
	push_first (&head, 1);
	push_last (&head, 6);
	push_last (&head, 9);
	push_last (&head, 10);
	push_last (&head, 11);
	push_on_position (&head, 7, 7);
	push_on_position (&head, 8, 8);
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

	/* 4. move the head to point to the new node */
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
	if (*head == NULL)
	{
		*head = new_node;
		return;
	}

	/* 5. Else traverse till the last node */
	while (last->next != NULL)
		last = last->next;

	/* 6. Change the next of last node */
	last->next = new_node;

	size++;
}

// function to create and return a Node
struct Node* getNode(int val) {

	// allocating space
	struct Node* newNode = (struct Node*) malloc(sizeof(struct Node));

	// inserting the required data
	newNode -> data = val;
	newNode -> next = NULL;
	return newNode;
}

// function to insert a Node at required postion
void push_on_position (struct Node** head, int pos, int val) {

	// This condition to check whether the
	// postion given is valid or not.
	if (pos < 1 || pos > size + 1)
		printf( "Invalid postion!");

	else {

		// Keep looping until the pos is zero
		while (pos--) {

			if (pos == 0) {

				// adding Node at required postion
				struct Node* temp = getNode(val);

				// Making the new Node to point to
				// the old Node at the same position
				temp->next = *head;

				// Changing the pointer of the Node previous
				// to the old Node to point to the new Node
				*head = temp;
			}
			else
				// Assign double pointer variable to point to the
				// pointer pointing to the address of next Node
				head = &(*head)->next;
		}
		size++;
	}
}

/* Function to remove the last node of the linked list */
struct Node* removeLastNode(struct Node* head) {

	if (head == NULL)
		return NULL;

	if (head->next == NULL) {
		free (head);
		return NULL;
	}

	// Find the second last node
	struct Node *second_last = head;

	while (second_last->next->next != NULL)
		second_last = second_last->next;

	// Delete last node
	free (second_last->next);

	// Change next of second last
	second_last->next = NULL;

	return head;
}

void printList (struct Node *n) {

	while (n != NULL) {
		printf(" %d ", n -> data);
		n = n -> next;
	}
	printf("\n");
}


