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

	if (head == NULL)
		return 0;

	else if (head -> next == head) 
		return head -> data;

	else{

		int sum = head -> data;
		struct Node * cursor = head -> next;
		while (cursor != head) {
			sum += (cursor -> data);
			cursor = cursor -> next;
		}
		return sum;
	}
}
