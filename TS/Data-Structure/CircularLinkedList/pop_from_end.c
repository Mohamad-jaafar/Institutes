/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif
/* Function to remove the cursor node of the linked list */
struct Node* pop_from_end(struct Node** head) {

	if (*head == NULL)
		return NULL;

	if ((*head)->next == *head) {
		free (*head);
		return NULL;
	}

	if ((*head) -> next -> next == *head) {
		free ((*head) -> next);
		(*head) -> next = *head;
		return NULL;
	}

	// Point to head
	struct Node *cursor = *head;

	while (cursor -> next -> next != *head)
		cursor = cursor -> next;
	
	struct Node *end = cursor -> next;

	// Delete cursor node
	free (end);

	cursor-> next = *head;

	return (*head);
}
