/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif
/* Given a reference (pointer to pointer) to the head of a list and an int, appends a new node at the end */
void push_on_end (struct Node **head, int val){

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
}
