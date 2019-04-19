/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

#include <stdio.h>
#ifndef NODE_H
#define NODE_H
#include "node.h"
#endif
struct Node * copy_rcsv (struct Node *head) {

	if (head == NULL) {
		return NULL;
	} else {
		struct Node * newnode;
		newnode = (struct Node *) malloc (sizeof(struct Node));
		newnode -> data = head -> data;
		newnode -> next = copy_rcsv (head -> next);
	}
}
