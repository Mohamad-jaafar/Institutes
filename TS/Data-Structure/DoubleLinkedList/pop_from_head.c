/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif
/* Function to remove the first node of the linked list */
struct Node* pop_from_head(struct Node** head) {

	if (*head == NULL)
		return NULL;

	if ((*head)->next == NULL) {
		free (*head);
		return NULL;
	}

	// Point to head
	struct Node *first = *head;

	first -> next -> prev = NULL;

	// Let head point to the second node
	(*head) = first -> next;

	// Delete first node
	free (first);

	return (*head);
}
