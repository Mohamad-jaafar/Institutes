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
int sum_iter (struct Node *head) {

	struct Node *cursor = head;
	int sum = 0;
	while (head != NULL) {
		sum += head -> data;
		head = head -> next;
	}
	return sum;
}
