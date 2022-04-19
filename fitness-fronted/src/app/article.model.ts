import { ArticleType } from "./article-type";

export interface Article {
    id: number;
    name: string;
    description: string;
    image: string;
    type: ArticleType;
    favorite: boolean;
}