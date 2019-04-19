/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif

/* Function to remove the last node of the linked list */
struct Node* pop_from_end(struct Node* head) {

	/* base case */
	if (head == NULL) 
		return NULL; 

	struct Node* cursor = head;

	/* If node to be deleted is head node */
	if (cursor -> next == NULL){

		free (head);
		return NULL;
	}

	while (cursor -> next != NULL){

		cursor = cursor -> next;
	}

	cursor -> prev -> next = NULL;

	/* Finally, free the memory occupied by del*/
	free(cursor);
}
