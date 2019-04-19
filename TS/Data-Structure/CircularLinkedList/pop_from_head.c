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
struct Node* pop_from_head(struct Node** head) {

	if (*head == NULL)
		return NULL;

	if ((*head)->next == *head) {
		free (*head);
		return NULL;
	}

	// Point to head
	struct Node *cursor = *head;

	while (cursor -> next != *head)
		cursor = cursor -> next;

	cursor -> next = (*head) -> next;
	
	struct Node *first = (*head);

	(*head) = (*head) -> next;

	// Delete cursor node
	free (first);

	return (*head);
}
