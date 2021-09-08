//
//  ViewController.swift
//  lab_01
//
//  Created by Reid Pritchard on 8/27/21.
//

import UIKit

class ViewController: UIViewController {
    var image_index = 0;
    var all_captions = ["Down down baby", "Down down the rollercoaster", "Sweet sweet baby", "sweet sweet don't let me go"]
    
    @IBOutlet weak var image_window: UIImageView!
    @IBOutlet weak var caption_label: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    func update_image_and_caption(index: Int) {
        image_window.image = UIImage(named: "stairs-"+String(index))
        caption_label.text = all_captions[image_index]
    }

    @IBAction func next(_ sender: Any) {
        image_index = image_index == 3 ? 0 : image_index + 1
        update_image_and_caption(index: image_index)
    }
    
    @IBAction func previous(_ sender: Any) {
        image_index = image_index == 0 ? 3 : image_index - 1
        update_image_and_caption(index: image_index)
    }
}

