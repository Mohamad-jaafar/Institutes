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
int length_iter (struct Node *head) {

	int counter = 0;
	struct Node * cursor = head;

	while (cursor != NULL) {
		counter ++;
		cursor = cursor -> next;
	}
	return counter;
}
