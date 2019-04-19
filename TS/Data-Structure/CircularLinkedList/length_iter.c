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

	if (head == NULL)
		return 0;

	else if (head -> next == head) 
		return 1;

	else{

		int counter = 1;
		struct Node * cursor = head -> next;
		while (cursor != head) {
			counter ++;
			cursor = cursor -> next;
		}
		return counter;
	}
}
