#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
/* Given a reference (pointer to pointer) to the head of a list and an int, inserts a new node on the front of the list. */
void push_first_iter (struct Node **head, int val){

	/* 1. allocate node */
	struct Node *new_node = (struct Node*) malloc (sizeof (struct Node));

	/* 2. put in the data */
	new_node -> data = val;

	/* 3. Make next of new node as head */
	new_node -> next = *head;

	/* 4. move the head to point to the new node */
	*head = new_node;
}
