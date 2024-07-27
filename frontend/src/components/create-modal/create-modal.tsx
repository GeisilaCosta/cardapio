import { useEffect, useState } from 'react';
import { useFoodDataMutate } from '../../hooks/useFoodDataMutate';
import { FoodData } from '../../interface/foodData';

import "./modal.css";

interface inputProps {
  label: string;
  value: string | number;
  updateValue: (value: any) => void;
}

interface modalProps {
  closeModal: () => void;
}

const Input: React.FC<inputProps> = ({ label, value, updateValue }) => {
  return (
    <>
      <label>{label}</label>
      <input value={value} onChange={(event) => updateValue(event.target.value)} />
    </>
  );
};

export function CreateModal({ closeModal }: modalProps) {
  const [title, setTitle] = useState("");
  const [price, setPrice] = useState<number>(0);
  const [image, setImage] = useState("");
  const { mutate, isSuccess, status, error } = useFoodDataMutate();

  const submit = () => {
    const foodData: FoodData = {
      title,
      price,
      image,
    };
    mutate(foodData);
  };

  useEffect(() => {
    if (!isSuccess) return;
    closeModal();
  }, [isSuccess]);

  if (error) {
    console.error(error);
  }

  return (
    <div className="modal-overlay">
      <div className="modal-body">
        <h2>Cadastre um novo item no cardápio</h2>
        <form className="input-container">
          <Input label="title" value={title} updateValue={setTitle} />
          <Input label="price" value={price} updateValue={(value) => setPrice(Number(value))} />
          <Input label="image" value={image} updateValue={setImage} />
        </form>
        <button onClick={submit} className="btn-secondary">
        {status === 'pending' ? "postando..." : "postar"}
        </button>
      </div>
    </div>
  );
}