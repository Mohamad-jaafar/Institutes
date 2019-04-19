#ifndef HEADERFILE_H
#define HEADERFILE_H
#include "node.h"
#endif
/* Function to remove the last node of the linked list */
struct Node* pop_from_end(struct Node* head) {

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
