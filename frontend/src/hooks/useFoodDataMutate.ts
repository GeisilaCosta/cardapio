import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios, { AxiosPromise } from "axios"
import { FoodData } from '../interface/foodData';

const API_URL = 'http://localhost:8080';

const postData = async (data: FoodData): AxiosPromise<any> => {
    const response = axios.post(API_URL + '/food', data);
    return response;
}

export function useFoodDataMutate(){
    const queryClient = useQueryClient();
    const mutate = useMutation({
        mutationFn: postData,
        retry: 2,
        onSuccess: () => {
            queryClient.invalidateQueries({ predicate: (query) => query.queryKey.includes('food-data') })
          }
    })

    return mutate;
}