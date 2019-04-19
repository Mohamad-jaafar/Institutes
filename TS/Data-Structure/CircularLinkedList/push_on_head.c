/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif
/* Given a reference (pointer to pointer) to the head of a list and an int, inserts a new node on the front of the list. */
void push_on_head (struct Node **head, int val){

	
	/* 1. allocate node */
	struct Node *new_node = (struct Node*) malloc (sizeof (struct Node));

	/* 2. put in the data */
	new_node -> data = val;

	/* 3. Make next of new node as head */
	new_node -> next = *head;

	/* 4. change prev of head node to new node */
	if (*head == NULL) {
		new_node -> next = new_node; /*For the first node */
	}
	else {

		/* If linked list is not NULL then set the next of last node */
		struct Node *cursor = *head;

		while (cursor -> next != *head)
			cursor = cursor -> next;

		cursor -> next = new_node;
	}

	/* 5. move the head to point to the new node */
	*head = new_node;

}
