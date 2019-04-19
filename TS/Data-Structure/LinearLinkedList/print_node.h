/*
 * Created on: Apr 11, 2019
 * Author: Mohamad-Jaafar NEHME
 * Email: mohamad.jaafar.nehme[att]gmail(.)com
 */

void print_node (struct Node *head){

	printf("[ %d | -]--> ", head -> data);
}

void print_reverse_node (struct Node *head){

	printf("<--[- | %d ]", head -> data);
}
